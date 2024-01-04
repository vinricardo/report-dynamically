package ricardo.vinicius.report.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ParameterDTO {
    private String title;
    private String field;
}
