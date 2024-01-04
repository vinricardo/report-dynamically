package ricardo.vinicius.report.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ricardo.vinicius.report.dto.ParameterDTO;
import ricardo.vinicius.report.service.ReportService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {
    private final ReportService service;

    @PostMapping
    private ModelAndView generateReport(@RequestBody List<ParameterDTO> values){
        return service.findReport(values);
    }
}
