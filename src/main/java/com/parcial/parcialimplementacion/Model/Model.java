package com.parcial.parcialimplementacion.Model;

import com.parcial.parcialimplementacion.Portfolio.Portfolio;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "model")
public class Model implements Serializable {
    @Id
    @Getter()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long modelId;

    @Column()
    @NotBlank(message = "Model name must not be empty")
    @Size(min = 1, message = "Model name must be al least 1 character")
    @Getter()
    @Setter()
    private String modelName;

    @Column()
    @NotBlank(message = "Model description must not be empty")
    @Getter()
    @Setter()
    private String modelDescription;

    @OneToOne(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private Portfolio portfolio;

}
