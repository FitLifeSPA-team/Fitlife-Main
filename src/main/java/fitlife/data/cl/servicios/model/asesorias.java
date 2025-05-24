package fitlife.data.cl.servicios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asesorias")
public class asesorias {

    @Id
    private Integer id;

    @Column(name = "rut", nullable = false, unique = true, length = 12)
    private String rut;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(length = 50, nullable = false)
    private String tipo_asesoria;

    @Column(length = 10, nullable = false)
    private String precio_asesoria;
}
