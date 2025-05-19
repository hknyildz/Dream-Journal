package org.dreamy.dreamjournal.dream.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DreamAddRequest //extends DreamBaseRequest
{
    private String title;
    private String description;
    private String date;

}
