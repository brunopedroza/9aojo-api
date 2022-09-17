package br.com.fiap.abctechapi.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "ordens_servico")
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_prestador", nullable = false)
    private Long idPrestador;

    @ManyToMany
    private List<Servico> servicos;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "inicio_atendimento_id", foreignKey = @ForeignKey(name ="FK_inicio_atendimento_id"))
    private LocalEHoraOS inicioAtendimento;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fim_atendimento_id" , foreignKey = @ForeignKey(name ="FK_fim_atendimento_id"))
    private LocalEHoraOS fimAtendimento;


    public boolean temServicosMin (){
        return servicos.size() > 0;
    }

    public boolean ultrapassaServicosMax () {
        return servicos.size() > 15;
    }
}
