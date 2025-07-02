package com.finca.app.application.dto.commentary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentaryDtoResponse {

    private Long commentaryId;
    private String description;
    private Long userId;
    private Long fincaId;
}
