package model;

import java.util.UUID;
import lombok.Data;

import javax.swing.*;
import java.time.LocalDateTime;

@Data
public class Venda {
    private UUID id;
    private LocalDateTime dataDaVenda;
    private Produto produto;
    private int quantidadeDeProdutos;
    private float valorDaVenda;
}
