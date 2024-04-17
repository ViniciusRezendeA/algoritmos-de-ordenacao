import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Acomodacao implements Comparator<Acomodacao>, Comparable<Acomodacao> {
    private int roomId;
    private int hostId;
    private String roomType;
    private String country;
    private String city;
    private String neighbourhood;
    private int reviews;
    private double overallSatisfaction;
    private int accommodates;
    private double bedrooms;
    private double price;
    private String propertyType;

    // Construtor vazio
    public Acomodacao() {
    }

    public Acomodacao(int roomId) {
        this.roomId = roomId;
    }

    // Construtor com todos os atributos
    public Acomodacao(int roomId, int hostId, String roomType, String country, String city,
            String neighbourhood, int reviews, double overallSatisfaction,
            int accommodates, double bedrooms, double price, String propertyType) {
        this.roomId = roomId;
        this.hostId = hostId;
        this.roomType = roomType;
        this.country = country;
        this.city = city;
        this.neighbourhood = neighbourhood;
        this.reviews = reviews;
        this.overallSatisfaction = overallSatisfaction;
        this.accommodates = accommodates;
        this.bedrooms = bedrooms;
        this.price = price;
        this.propertyType = propertyType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + roomId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Acomodacao other = (Acomodacao) obj;
        if (roomId != other.roomId)
            return false;
        return true;
    }

    // Getters e setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public double getOverallSatisfaction() {
        return overallSatisfaction;
    }

    public void setOverallSatisfaction(double overallSatisfaction) {
        this.overallSatisfaction = overallSatisfaction;
    }

    public int getAccommodates() {
        return accommodates;
    }

    public void setAccommodates(int accommodates) {
        this.accommodates = accommodates;
    }

    public double getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(double bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }


    @Override
    public String toString() {
        return "Acomodacao [roomId=" + roomId + ", hostId=" + hostId + ", roomType=" + roomType + ", country=" + country
                + ", city=" + city + ", neighbourhood=" + neighbourhood + ", reviews=" + reviews
                + ", overallSatisfaction=" + overallSatisfaction + ", accommodates=" + accommodates + ", bedrooms="
                + bedrooms + ", price=" + price + ", propertyType=" + propertyType + "]";
    }

    @Override
    public int compare(Acomodacao a1, Acomodacao a2) {
        return Integer.compare(a1.getRoomId(), a2.getRoomId());
    }

    @Override
    public int compareTo(Acomodacao outraAcomodacao) {
        return Integer.compare(this.getRoomId(), outraAcomodacao.getRoomId());
    }

    // Método clone
    public Acomodacao clone() {
        return new Acomodacao(roomId, hostId, roomType, country, city, neighbourhood,
                reviews, overallSatisfaction, accommodates, bedrooms, price, propertyType);
    }

    public void ler(String linha) {
        // Separa a linha em campos usando o delimitador de tabulação
        String[] campos = linha.split("\t");

        // Atribui cada campo ao seu respectivo atributo, convertendo-os para o tipo
        // apropriado
        roomId = Integer.parseInt(campos[0]);
        hostId = Integer.parseInt(campos[1]);
        roomType = campos[2];
        country = campos[3];
        city = campos[4];
        neighbourhood = campos[5];
        reviews = Integer.parseInt(campos[6]);
        overallSatisfaction = Double.parseDouble(campos[7]);
        accommodates = Integer.parseInt(campos[8]);
        bedrooms = Double.parseDouble(campos[9]);
        price = Double.parseDouble(campos[10]);
        propertyType = campos[11];
    }

    // Método imprimir para exibir os dados do objeto
    public void imprimir() {
        System.out.println("[" + roomId + " ## " + hostId + " ## " + roomType + " ## " + country
                + " ## " + city + " ## " + neighbourhood + " ## " + reviews + " ## "
                + overallSatisfaction + " ## " + accommodates + " ## " + bedrooms + " ## "
                + price + " ## " + propertyType + "]");
    }

}

public class Ordenacoes {

    public static List<Acomodacao> acomodacoes;

    public static void main(String[] args) throws Exception {
        pegarDadosDoArquivo();
        acomodacoes.sort(new Acomodacao());

        SelecionarAcomodacoes();

    }

    public static void pegarDadosDoArquivo() {
        acomodacoes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("tmp/dados_airbnb.txt"))) {

            reader.readLine();// Tirar o cabeçalho

            String linha = reader.readLine();

            while (linha != null) {
                Acomodacao aux = new Acomodacao();
                aux.ler(linha);
                acomodacoes.add(aux);

                linha = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void SelecionarAcomodacoes() {
        List<Acomodacao> newList = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int roomId = scan.nextInt();
            int roomIndex = Collections.binarySearch(acomodacoes, new Acomodacao(roomId));
            newList.add(acomodacoes.get(roomIndex));
        }

        System.out.println(newList);
        
        acomodacoes = newList;
        scan.close();
    }
}
