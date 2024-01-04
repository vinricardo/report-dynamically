package ricardo.vinicius.report.entity;

import jakarta.persistence.*;

@Table(name = "client")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String fullAddress;
}
