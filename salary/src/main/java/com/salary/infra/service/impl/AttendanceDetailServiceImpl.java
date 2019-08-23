package com.salary.infra.service.impl;

import com.salary.app.dto.AttendanceDetailDTO;
import com.salary.app.dto.AttendanceRecordDTO;
import com.salary.infra.service.AttendanceDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 下午3:52
 */
@Service
public class AttendanceDetailServiceImpl implements AttendanceDetailService {
    @Override
    public List<AttendanceDetailDTO> listAttendanceDetail() {
        List<AttendanceDetailDTO> attendanceDetailDTOList=new ArrayList<>();
        AttendanceDetailDTO attendanceDetailDTO=new AttendanceDetailDTO();
        attendanceDetailDTO.setAttendanceId(1001L);
        attendanceDetailDTO.setStaffName("张三");
        attendanceDetailDTO.setJobNumber("YS1001");
        attendanceDetailDTO.setDeptName("技术部");

        List<AttendanceRecordDTO> attendanceRecordDTOList=new ArrayList<>();
        //设置每天考勤记录
        AttendanceRecordDTO attendanceRecordDTO=new AttendanceRecordDTO();
        attendanceRecordDTO.setWorkDate(1L);
        attendanceRecordDTO.setAttendanceClass("A班");
        attendanceRecordDTO.setOnDutyTime("8:50");
        attendanceRecordDTO.setOnDutyResult("正常");
        attendanceRecordDTO.setOnDutyIsNormal(0);
        attendanceRecordDTO.setOffDutyTime("17:58");
        attendanceRecordDTO.setOffDutyResult("早退");
        attendanceRecordDTO.setOffDutyIsNormal(0);
        attendanceRecordDTO.setViolationIds(Collections.emptyList());
        attendanceRecordDTO.setRemark("早退");

        //设置每天考勤记录
        AttendanceRecordDTO attendanceRecordDTO2=new AttendanceRecordDTO();
        attendanceRecordDTO2.setWorkDate(2L);
        attendanceRecordDTO2.setAttendanceClass("B班");
        attendanceRecordDTO2.setOnDutyTime("9:21");
        attendanceRecordDTO2.setOnDutyResult("正常");
        attendanceRecordDTO2.setOnDutyIsNormal(1);
        attendanceRecordDTO2.setOffDutyTime("18:58");
        attendanceRecordDTO2.setOffDutyResult("正常");
        attendanceRecordDTO2.setOffDutyIsNormal(1);
        attendanceRecordDTO2.setViolationIds(Collections.emptyList());
        attendanceRecordDTO2.setRemark("正常上班");

        attendanceRecordDTOList.add(attendanceRecordDTO);
        attendanceRecordDTOList.add(attendanceRecordDTO2);

        List<AttendanceRecordDTO> updateAttendanceRecordList=attendanceRecordDTOList.stream().filter(attendanceRecordDto -> attendanceRecordDto.getOnDutyIsNormal()==1||attendanceRecordDto.getOffDutyIsNormal()==1).collect(Collectors.toList());

        attendanceDetailDTO.setAttendanceRecordDtoList(updateAttendanceRecordList);

        attendanceDetailDTOList.add(attendanceDetailDTO);


        return attendanceDetailDTOList;
    }
}
