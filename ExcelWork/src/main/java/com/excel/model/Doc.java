package com.excel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhourui
 */
@Data
@Getter
@Setter
public class Doc {
    private String docDept;
    private String docName;
    private String docSex;
    private String docCause;
}