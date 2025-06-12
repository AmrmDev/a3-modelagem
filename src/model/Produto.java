package model;

import java.util.UUID;
import lombok.*;

@Data
public class Produto {
    private UUID id;
    private String nome;
    private double valor;
    private String marca;
    private Categoria categoria;
    private String vencimento;

}
