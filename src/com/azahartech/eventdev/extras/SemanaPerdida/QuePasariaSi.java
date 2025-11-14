package com.azahartech.eventdev.extras.SemanaPerdida;

public class QuePasariaSi {
    public static void main(String[] args) {
        int personas = 30;
        int gatos = 30;
        int perros = 25;
        if (personas < gatos) {
            System.out.println("¡Demasiados gatos!¡El mundo está condenado!");
        } else if (personas > gatos) {
            System.out.println("¡No hay demasiados gatos!¡El mundo está a salvo!");
        }
        if (personas < perros) {
            System.out.println("¡El mundo está babeando!");
        } else if (personas > perros) {
            System.out.println("¡El mundo está seco!");
        }
        perros += 5;
        if (personas >= perros) {
            System.out.println("Hay un número igual o superior de personas que de perros.");
        } else if (personas <= perros) {
            System.out.println("Hay un número igual o inferior de personas que de perros.");
        } else if (personas == perros) {
            System.out.println("Las personas son perros.");
        }

    }
}
