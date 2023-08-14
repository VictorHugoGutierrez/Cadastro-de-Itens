package cadastrodeitens;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class funcoesCadastroItens {
    public static ArrayList<String> sItens = new ArrayList<>();
    public static ArrayList<Float> fValores = new ArrayList<>();
    public static ArrayList<Integer> iSeriais = new ArrayList<>();
    public static ArrayList<String> sDepartamentos = new ArrayList<>();
    
    // Menu principal
    public static void menuPricipal() {
        UIManager.put("OptionPane.minimumSize", new Dimension(500, 150));
        int iResposta;
        while (true) {
            String[] itens = { "Cadastrar Itens", "Buscar Itens", "Editar Itens", "Excluir Itens", "Listar Itens" };
            String oOp = String.valueOf(JOptionPane.showInputDialog(null, "Escolha a opção desejada:",
                    "Menu de Opções", JOptionPane.QUESTION_MESSAGE, null, itens, null));
            if ("null".equals(oOp)) {
                break;
            } else {
                switch (oOp) {
                    case "Cadastrar Itens":
                        iResposta = 0;
                        cadastrarItens(iResposta, oOp);
                        break;
                    case "Buscar Itens":
                        buscarItens(oOp);
                        break;
                    case "Editar Itens":
                        editarItens(oOp);
                    case "Excluir Itens":
                        excluirItens(oOp);
                        break;
                    case "Listar Itens":
                        listarItens(oOp);
                        break;
                }
            }
        }
    }

    // Cadastro de Itens
    public static void cadastrarItens(int iResposta, Object oOp) {
        String sTitulo = String.valueOf(oOp);
        while (iResposta == 0) {
            sItens.add(JOptionPane.showInputDialog(null, "Digite o Nome do Item:", sTitulo,
                    JOptionPane.INFORMATION_MESSAGE));
            fValores.add(Float.valueOf(JOptionPane.showInputDialog(null, "Digite o Valor do Item:", sTitulo,
                    JOptionPane.INFORMATION_MESSAGE)));
            iSeriais.add(Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o Serial do Item:", sTitulo,
                    JOptionPane.INFORMATION_MESSAGE)));
            sDepartamentos.add(JOptionPane.showInputDialog(null, "Digite o Departamento do Item:", sTitulo,
                    JOptionPane.INFORMATION_MESSAGE));
            iResposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais itens?", "Escolha",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        int iRes2 = JOptionPane.showConfirmDialog(null, "Deseja que liste todos os itens cadastrados?", sTitulo,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (iRes2 == 0) {
            listarItens(oOp);
        }
    }

    // Altera Itens
    public static void buscarItens(Object oOp) {
        String sTitulo = String.valueOf(oOp);
        String sBusca = JOptionPane.showInputDialog(null, "Digite o nome do Item que deseja buscar: ", sTitulo,
                JOptionPane.QUESTION_MESSAGE);
        for (int iIndice = 0; iIndice < sItens.size(); iIndice++) {
            if (sBusca.equals(sItens.get(iIndice))) {
                JOptionPane.showMessageDialog(null,
                        "Valor: " + fValores.get(iIndice) + "\nSerial: " + iSeriais.get(iIndice) + "\nDepartamento: "
                                + sDepartamentos.get(iIndice) + "\nClique em OK para continuar...",
                        sTitulo, JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Item não encontrado!\nClique em OK para continuar...", sTitulo,
                        JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
        int iRes2 = JOptionPane.showConfirmDialog(null, "Deseja buscar mais itens?", sTitulo, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (iRes2 == 0) {
            buscarItens(oOp);
        }
    }

    // Altera Itens
    public static void editarItens(Object oOp) {
        String sTitulo = String.valueOf(oOp);
        while (true) {
            String[] itens2 = { "Mudar Nome", "Mudar Valor", "Mudar Serial", "Mudar Departamento" };
            String oOp2 = String.valueOf(JOptionPane.showInputDialog(null, "Escolha a opção desejada:",
                    sTitulo, JOptionPane.QUESTION_MESSAGE, null, itens2, null));
            JOptionPane.showMessageDialog(null, oOp2);
            if ("null".equals(oOp2)) {
                menuPricipal();
                break;
            } else {
                switch (oOp2) {
                    case "Mudar Nome":
                        mudarNome(oOp2, sTitulo);
                    case "Mudar Valor":
                        mudarValor(oOp2, sTitulo);
                    case "Mudar Serial":
                        mudarSerial(oOp2, sTitulo);
                    case "Mudar Departamento":
                        mudarDepartamento(oOp2, sTitulo);
                }
            }
        }
    }

    // Altera o nome do Item
    public static void mudarNome(Object oOp2, String sTitulo) {
        String sTitulo2 = String.valueOf(oOp2);
        String sNome = JOptionPane.showInputDialog(null, "Digite o nome do Item que deseja mudar o nome: ", sTitulo2,
                JOptionPane.QUESTION_MESSAGE);
        for (int iIndice = 0; iIndice < sItens.size(); iIndice++) {
            if (sNome.equals(sItens.get(iIndice))) {
                sItens.set(iIndice,
                        JOptionPane.showInputDialog(null,
                                "Nome Antigo: " + sItens.get(iIndice) + "\nDigite um novo Nome:  ", sTitulo2,
                                JOptionPane.QUESTION_MESSAGE));
                JOptionPane.showMessageDialog(null, "Novo Nome: " + sItens.get(iIndice), sTitulo2,
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Item não encontrado!\nClique em OK para continuar...", sTitulo2,
                        JOptionPane.ERROR_MESSAGE);
                editarItens(sTitulo);
                break;
            }
        }
        int iRes2 = JOptionPane.showConfirmDialog(null, "Deseja mudar o nome de mais algum item?", sTitulo2,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (iRes2 == 0) {
            mudarNome(oOp2, sTitulo);
        } else {
            editarItens(sTitulo);
        }
    }

    // Altera o valor do item
    public static void mudarValor(Object oOp2, String sTitulo) {
        String sTitulo2 = String.valueOf(oOp2);
        String sValor = JOptionPane.showInputDialog(null, "Digite o nome do Item que deseja mudar o valor: ", sTitulo2,
                JOptionPane.QUESTION_MESSAGE);
        for (int iIndice = 0; iIndice < sItens.size(); iIndice++) {
            if (sValor.equals(sItens.get(iIndice))) {
                fValores.set(iIndice,
                        Float.valueOf(JOptionPane.showInputDialog(null,
                                "Valor Antigo: " + fValores.get(iIndice) + "\nDigite um novo Valor:  ", sTitulo2,
                                JOptionPane.QUESTION_MESSAGE)));
                JOptionPane.showMessageDialog(null, "Novo Valor: " + fValores.get(iIndice), sTitulo2,
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Item não encontrado!\nClique em OK para continuar...", sTitulo2,
                        JOptionPane.ERROR_MESSAGE);
                editarItens(sTitulo);
                break;
            }
        }
        int iRes2 = JOptionPane.showConfirmDialog(null, "Deseja mudar o valor de mais algum item?", sTitulo2,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (iRes2 == 0) {
            mudarValor(oOp2, sTitulo);
        } else {
            editarItens(sTitulo);
        }
    }

    // Altera Serial
    public static void mudarSerial(Object oOp2, String sTitulo) {
        String sTitulo2 = String.valueOf(oOp2);
        String sSerial = JOptionPane.showInputDialog(null, "Digite o nome do Item que deseja mudar o serial: ",
                sTitulo2, JOptionPane.QUESTION_MESSAGE);
        for (int iIndice = 0; iIndice < sItens.size(); iIndice++) {
            if (sSerial.equals(sItens.get(iIndice))) {
                iSeriais.set(iIndice,
                        Integer.valueOf(JOptionPane.showInputDialog(null,
                                "Serial Antigo: " + iSeriais.get(iIndice) + "\nDigite um novo Serial:  ", sTitulo2,
                                JOptionPane.QUESTION_MESSAGE)));
                JOptionPane.showMessageDialog(null, "Novo Serial: " + iSeriais.get(iIndice), sTitulo2,
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Item não encontrado!\nClique em OK para continuar...", sTitulo2,
                        JOptionPane.ERROR_MESSAGE);
                editarItens(sTitulo);
                break;
            }
        }
        int iRes2 = JOptionPane.showConfirmDialog(null, "Deseja mudar o serial de mais algum item?", sTitulo2,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (iRes2 == 0) {
            mudarValor(oOp2, sTitulo);
        } else {
            editarItens(sTitulo);
        }
    }

    // Altera Departamento
    public static void mudarDepartamento(Object oOp2, String sTitulo) {
        String sTitulo2 = String.valueOf(oOp2);
        String sDepartamento = JOptionPane.showInputDialog(null,
                "Digite o nome do Item que deseja mudar o departamento: ", sTitulo2, JOptionPane.QUESTION_MESSAGE);
        for (int iIndice = 0; iIndice < sItens.size(); iIndice++) {
            if (sDepartamento.equals(sItens.get(iIndice))) {
                sDepartamentos.set(iIndice, JOptionPane.showInputDialog(null,
                        "Departamento Antigo: " + sDepartamentos.get(iIndice) + "\nDigite um novo Departamento:  ",
                        sTitulo2, JOptionPane.QUESTION_MESSAGE));
                JOptionPane.showMessageDialog(null, "Novo Departamento: " + sDepartamentos.get(iIndice), sTitulo2,
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Item não encontrado!\nClique em OK para continuar...", sTitulo2,
                        JOptionPane.ERROR_MESSAGE);
                editarItens(sTitulo);
                break;
            }
        }
        int iRes2 = JOptionPane.showConfirmDialog(null, "Deseja mudar o departamento de mais algum item?", sTitulo2,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (iRes2 == 0) {
            mudarNome(oOp2, sTitulo);
        } else {
            editarItens(sTitulo);
        }
    }

    // Exclui itens
    public static void excluirItens(Object oOp) {
        String sTitulo = String.valueOf(oOp);
        String sNome = JOptionPane.showInputDialog(null, "Digite o nome do item que será excluído:", sTitulo,
                JOptionPane.QUESTION_MESSAGE);
        for (int indice = 0; indice < sItens.size(); indice++) {
            if (sItens.get(indice).equals(sNome)) {
                sDepartamentos.remove(indice);
                sItens.remove(indice);
                iSeriais.remove(indice);
                fValores.remove(indice);
                JOptionPane.showMessageDialog(null, "Equipamento excluído com sucesso!", sTitulo,
                        JOptionPane.INFORMATION_MESSAGE);
                int iRes2 = JOptionPane.showConfirmDialog(null, "Deseja que liste todos os itens cadastrados?", sTitulo,
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (iRes2 == 0) {
                    listarItens(oOp);
                }
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Equipamento não encontrado!", sTitulo, JOptionPane.ERROR_MESSAGE);
                menuPricipal();
                break;
            }
        }
        int iRes2 = JOptionPane.showConfirmDialog(null, "Deseja excluir mais algum item?", sTitulo,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (iRes2 == 0) {
            excluirItens(oOp);
        } else {
            menuPricipal();
        }
    }

    // Lista todos os Itens
    public static void listarItens(Object oOp) {
        String sTitulo = String.valueOf(oOp);
        for (int iIndice = 0; iIndice < sItens.size(); iIndice++) {
            JOptionPane.showMessageDialog(null,
                    "Item: " + (iIndice + 1) + "\nNome do Item: " + sItens.get(iIndice) + "\nValor: "
                            + fValores.get(iIndice) + "\nSerial: " + iSeriais.get(iIndice) + "\nDepartamento: "
                            + sDepartamentos.get(iIndice) + "\nClique em OK para continuar...",
                    sTitulo, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}