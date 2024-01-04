package ricardo.vinicius.report.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import ricardo.vinicius.report.dto.ParameterDTO;
import ricardo.vinicius.report.entity.Client;
import ricardo.vinicius.report.repository.ClientRepository;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ClientRepository repository;

    public ModelAndView findReport(List<ParameterDTO> values){
        List<Client> clients = repository.findAll();

        ModelAndView mv = new ModelAndView("client");
        mv.addObject("year", LocalDateTime.now().getYear());

        List<List<Object>> clientsMap = new ArrayList<>();
        for (Client client : clients) {
            LinkedHashMap<String, Object> participantHash = new LinkedHashMap<>();
            AtomicInteger i = new AtomicInteger(0);

            values.forEach((v) -> {
                Field field = null;
                try {
                    field = client.getClass().getDeclaredField(v.getField());
                    field.setAccessible(true);
                    Object value = field.get(client);
                    participantHash.put("field-" + i.get(), value);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                i.getAndIncrement();
            });
                clientsMap.add(participantHash.values().stream().toList());
        }

        mv.addObject("clients", clientsMap);
        mv.addObject("values", values.stream().map(ParameterDTO::getTitle).toList());

        return mv;
    }
}
