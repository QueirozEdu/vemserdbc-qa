import java.util.*;
import java.util.stream.Collectors;

public class Stream {
        public static void main(String[] args) {
            List<Pessoa> lista = new ArrayList<>();
            int i = 0;
            lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
            lista.add(new Pessoa(++i, "Pedro Paulo", 5300, "Desenvolvedor"));
            lista.add(new Pessoa(++i, "Enzo", 2350, "Desenvolvedor"));
            lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
            lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
            lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
            lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

            //1- listar todas as pessoas
            lista.stream()
                .forEach(Pessoa -> System.out.println(Pessoa.toString()));

            //2- filtrar todas as pessoas com salario maior do que 5 mil (filter)
            lista.stream()
                    .filter(pessoa -> pessoa.getSalario() > 5000)
                    .forEach(pessoa -> System.out.println(pessoa.getNome() + " -- " +pessoa.getSalario()));

            //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente (filter, sorted)
            List<Pessoa> listaComFiltro = lista.stream()
                    .filter(pessoa -> pessoa.getCargo().equalsIgnoreCase("Desenvolvedor"))
                    .sorted(Comparator.comparing(Pessoa::getSalario))
                    .toList();
            listaComFiltro.stream()
                    .forEach(pessoa -> System.out.println(pessoa.getNome() + "---" + pessoa.getCargo()));

            //4- fazer a média salarial de todos
                Double media = lista.stream()
                        .mapToDouble(Pessoa::getSalario)
                        .average()
                        .getAsDouble();
            System.out.println("Média: " + media);

            //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
            boolean verificacao = lista.stream()
                    .anyMatch(pessoa -> pessoa.getSalario() > 2000);
            System.out.println(verificacao);

            //6- retornar uma lista de todos os ids das pessoas
            List<Integer> ids = lista.stream()
                    .map(Pessoa::getId)
                    .toList();
            System.out.println(ids);

            //7- criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto
            List<Salario> listaDeSalario = lista.stream()
                    .map(pessoa -> new Salario(pessoa.getId(), pessoa.getSalario()))
                    .toList();
            listaDeSalario
                    .forEach(salario -> System.out.println("ID: " + salario.getId() + " Salário: " + salario.getSalario()));

            //8- retornar um HashMap (estrutura de dados, e não uma função map) contendo os ids e os nomes dos colaboradores
            Map<Integer, String> mapPessoas = lista.stream()
                    .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
            System.out.println(mapPessoas);

            //9- com o mapa da 8, retornar o nome com o id=2
            if (mapPessoas.containsKey(2)){
                System.out.println(mapPessoas.get(2));
            }
            //10- verificar se tem alguém que contenha o nome "Paulo" (containsignorecase) na lista e retornar o primeiro elemento que encontrar (findFirst).
            //    Imprimir o nome e salário dessa pessoa
            Optional<Pessoa> verificacao2 = lista.stream()
                    .filter(pessoa -> pessoa.getNome().toLowerCase().contains("paulo"))
                    .findFirst();
            verificacao2.ifPresent(pessoa -> System.out.println("Nome: " + pessoa.getNome() + "\n" +"Salario: " +pessoa.getSalario()));
        }

        static class Pessoa {
            private int id;
            private String nome;
            private double salario;
            private String cargo;

            public Pessoa(int id, String nome, double salario, String cargo) {
                this.id = id;
                this.nome = nome;
                this.salario = salario;
                this.cargo = cargo;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNome() {
                return nome;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }

            public double getSalario() {
                return salario;
            }

            public void setSalario(double salario) {
                this.salario = salario;
            }

            public String getCargo() {
                return cargo;
            }

            public void setCargo(String cargo) {
                this.cargo = cargo;
            }

            @Override
            public String toString() {
                return "Pessoa{" +
                        "id=" + id +
                        ", nome='" + nome + '\'' +
                        ", salario=" + salario +
                        ", cargo='" + cargo + '\'' +
                        '}';
            }
        }
        static class Salario{
            private int id;
            private double salario;

            public Salario(int id, double salario){
                this.id = id;
                this.salario = salario;
            }
            public int getId(){
                return id;
            }
            public void setId(int id){
                this.id = id;
            }
            public double getSalario(){
                return salario;
            }
            public void setSalario(double salario){
                this.salario = salario;
            }
        }


    }


