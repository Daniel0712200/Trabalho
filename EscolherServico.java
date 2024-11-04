private static int escolherServico() {
    String servicos;
        if (servicos.isEmpty()) {
        System.out.println("Não há serviços disponíveis para selecionar.");
        return -1; // Indica que não há serviços
    }

    System.out.println("Selecione um serviço a ser realizado:");
    for (int i = 0; i < servicos.size(); i++) {
        System.out.printf("%d - %s%n", i + 1, servicos.get(i));
    }

    while (true) {
        try {
            int opcaoServico = lerEntradaInt("Digite o número do serviço: ");
                        if (opcaoServico < 1 || opcaoServico > servicos.size()) {
                            System.out.println("Opção inválida! Tente novamente.");
                        } else {
                            return opcaoServico; // Retorna a opção válida
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida! Por favor, digite um número válido.");
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro ao escolher o serviço: " + e.getMessage());
                    }
                }
            }
            
            private static int lerEntradaInt(String string) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'lerEntradaInt'");
            }
