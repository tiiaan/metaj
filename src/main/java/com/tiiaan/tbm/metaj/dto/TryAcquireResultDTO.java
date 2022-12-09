package com.tiiaan.tbm.metaj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TryAcquireResultDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String issueId;

}
