import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class mergesort {
    private int id;
    private int generation;
    private String name;
    private String description;
    private String type1; 
    private String type2; 
    private ArrayList<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private LocalDate captureDate;

    public mergesort() {
        this.id = 0;
        this.generation = 0;
        this.name = "";
        this.description = "";
        this.type1 = "";
        this.type2 = "";
        this.abilities = new ArrayList<>();
        this.weight = 0;
        this.height = 0;
        this.captureRate = 0;
        this.isLegendary = false;
        this.captureDate = null;
    }

    public mergesort(int id, int generation, String name, String description, String type1, String type2,
                     ArrayList<String> abilities, double weight, double height, int captureRate,
                     boolean isLegendary, LocalDate captureDate) {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.type1 = type1;
        this.type2 = type2;
        this.abilities = new ArrayList<>(abilities);
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.isLegendary = isLegendary;
        this.captureDate = captureDate;
    }

    public void set(int id, int generation, String name, String description, String type1, String type2,
                    ArrayList<String> abilities, double weight, double height, int captureRate,
                    boolean isLegendary, LocalDate captureDate) {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.type1 = type1;
        this.type2 = type2;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.isLegendary = isLegendary;
        this.captureDate = captureDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void ler(String id) {
        String input;
        String path = "/tmp/pokemon.csv"; // Caminho do arquivo CSV
        try {
            File file = new File(path);
            Scanner scan = new Scanner(file);
            scan.nextLine(); // Ignorar o cabeçalho do arquivo

            if (scan.hasNextLine()) {
                boolean found = false;
                while (scan.hasNextLine() && !found) {
                    input = scan.nextLine();
                    if (id.equals(input.substring(0, input.indexOf(",")))) {
                        found = true;
                        String[] atributos = parseCsvLine(input);
                        set(
                            Integer.parseInt(atributos[0].trim()), 
                            Integer.parseInt(atributos[1].trim()), 
                            atributos[2].trim(), 
                            atributos[3].trim(), 
                            atributos[4].trim(), 
                            atributos[5].trim(), 
                            parseAbilities(atributos[6].trim()), 
                            parseDouble(atributos[7]), 
                            parseDouble(atributos[8]), 
                            parseInt(atributos[9]), 
                            parseBoolean(atributos[10]), 
                            parseLocalDate(atributos[11])
                        );

                        if (this.weight < 0) {
                            setWeight(0.0);
                        }
                        if (this.height < 0) {
                            setHeight(0.0);
                        }
                    }
                }
                if (!found) {
                    System.out.println("Pokémon não encontrado.");
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File Not Found.");
        }
    }

    private String[] parseCsvLine(String line) {
        String regex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        return line.split(regex);
    }

    private static ArrayList<String> parseAbilities(String abilitiesString) {
        abilitiesString = abilitiesString.replace("\"", "").replace("[", "").replace("]", "").trim();
        String[] abilitiesArray = abilitiesString.split(",\\s*");
        ArrayList<String> abilitiesList = new ArrayList<>();
        for (String ability : abilitiesArray) {
            abilitiesList.add(ability.trim());
        }
        return abilitiesList;
    }

    private double parseDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private int parseInt(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(value.trim());
    }

    private boolean parseBoolean(String value) {
        return value != null && Integer.parseInt(value.trim()) > 0;
    }

    private LocalDate parseLocalDate(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(value.trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            return null;
        }
    }

    public void imprimirPokemon() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = captureDate != null ? captureDate.format(formatter) : "N/A";
        System.out.println("[#" + id + " -> " + name + ": " + description + " - " + 
            "['" + type1  + (type2.isEmpty() ? "" : "', '" + type2) + "']" +" - "  + abilities + " - " +
            weight + "kg" + " - " + height + "m" + " - " + captureRate + "% - " + 
            isLegendary + " - " + generation +" gen] - " + formattedDate);
    }

    public String getType1ForComparison() {
        return type1.toLowerCase();
    }

    public String getNameForComparison() {
        return name.toLowerCase();
    }

    public static void mergeSort(ArrayList<mergesort> pokemons, int left, int right, int comparisons[], int movements[]) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(pokemons, left, mid, comparisons, movements);
            mergeSort(pokemons, mid + 1, right, comparisons, movements);
            merge(pokemons, left, mid, right, comparisons, movements);
        }
    }

    private static void merge(ArrayList<mergesort> pokemons, int left, int mid, int right, int comparisons[], int movements[]) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<mergesort> leftArray = new ArrayList<>(pokemons.subList(left, mid + 1));
        ArrayList<mergesort> rightArray = new ArrayList<>(pokemons.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            comparisons[0]++;
            if (leftArray.get(i).getType1ForComparison().compareTo(rightArray.get(j).getType1ForComparison()) < 0 ||
                (leftArray.get(i).getType1ForComparison().equals(rightArray.get(j).getType1ForComparison()) &&
                 leftArray.get(i).getNameForComparison().compareTo(rightArray.get(j).getNameForComparison()) < 0)) {
                pokemons.set(k++, leftArray.get(i++));
            } else {
                pokemons.set(k++, rightArray.get(j++));
                movements[0]++;
            }
        }

        while (i < n1) {
            pokemons.set(k++, leftArray.get(i++));
        }

        while (j < n2) {
            pokemons.set(k++, rightArray.get(j++));
        }
    }

    public static void main(String[] args) {
        ArrayList<mergesort> pokemonList = new ArrayList<>();
        Scanner scanf = new Scanner(System.in);
        String input;

        // Lê os IDs dos Pokémons
        while (true) {
            input = scanf.nextLine();
            if (input.equalsIgnoreCase("FIM")) {
                break;
            }
            mergesort pokemon = new mergesort();
            pokemon.ler(input);
            pokemonList.add(pokemon);
        }

        // Variáveis para contagem de comparações e movimentações
        int[] comparisons = {0};
        int[] movements = {0};

        // Ordena os Pokémons em ordem alfabética
        long startTime = System.nanoTime();
        mergeSort(pokemonList, 0, pokemonList.size() - 1, comparisons, movements);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Imprime os Pokémons em ordem alfabética
        for (mergesort pokemon : pokemonList) {
            pokemon.imprimirPokemon();
        }

        // Criação do log
        String logFileName = "matricula_mergesort.txt"; // Substitua "matricula" pela sua matrícula
        try (FileWriter writer = new FileWriter(logFileName)) {
            writer.write("855476\t" + comparisons[0] + "\t" + movements[0] + "\t" + (duration / 1e6) + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo de log: " + e.getMessage());
        }

        scanf.close(); // Fecha o scanner
    }
}
