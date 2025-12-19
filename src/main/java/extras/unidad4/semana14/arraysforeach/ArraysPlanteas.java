package extras.unidad4.semana14.arraysforeach;

public class ArraysPlanteas {
    public static void main(String[] args) {
        String[] planetas = {"Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno", "Plutón"};

        for (String planeta : planetas) {
            System.out.println(String.format("%s\t\t%s", planeta, planeta.toUpperCase()));
        }
    }

}
