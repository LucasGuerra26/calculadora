package visao;

import modelo.Memoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {

    private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
    private final Color COR_CINZA_CLARO = new Color(99, 99, 99);
    private final Color COR_LARANJA = new Color(242, 163, 60);

    public Teclado () {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setLayout(layout);

        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        adicioanrBotao("AC", COR_CINZA_ESCURO, c, 0, 0);
        c.gridwidth = 1;
        adicioanrBotao("+/-", COR_CINZA_ESCURO, c, 2, 0);
        adicioanrBotao("/", COR_LARANJA, c, 3, 0);

        adicioanrBotao("7", COR_CINZA_CLARO, c, 0, 1);
        adicioanrBotao("8", COR_CINZA_CLARO, c, 1, 1);
        adicioanrBotao("9", COR_CINZA_CLARO, c, 2, 1);
        adicioanrBotao("*", COR_LARANJA, c, 3, 1);

        adicioanrBotao("4", COR_CINZA_CLARO, c, 0, 2);
        adicioanrBotao("5", COR_CINZA_CLARO, c, 1, 2);
        adicioanrBotao("6", COR_CINZA_CLARO, c, 2, 2);
        adicioanrBotao("-", COR_LARANJA, c, 3, 2);

        adicioanrBotao("1", COR_CINZA_CLARO, c, 0, 3);
        adicioanrBotao("2", COR_CINZA_CLARO, c, 1, 3);
        adicioanrBotao("3", COR_CINZA_CLARO, c, 2, 3);
        adicioanrBotao("+", COR_LARANJA, c, 3, 3);

        c.gridwidth = 2;
        adicioanrBotao("0", COR_CINZA_CLARO, c, 0, 4);
        c.gridwidth = 1;
        adicioanrBotao(",", COR_CINZA_CLARO, c, 2, 4);
        adicioanrBotao("=", COR_LARANJA, c, 3, 4);

    }

    private void adicioanrBotao(String texto, Color cor, GridBagConstraints c,
                                int x, int y) {
        c.gridy = y;
        c.gridx = x;
        Botao botao = new Botao (texto, cor);
        botao.addActionListener(this);
        add(botao, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton botao = (JButton) e.getSource();
            Memoria.getInstancia().processarComando(botao.getText());
        }
    }
}
