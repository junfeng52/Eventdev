package extras.unidad4.semana14.buclestriangulos;

public class Triangulo {
    public static void printPattern(int size, String pattern){
        switch (pattern.toLowerCase()){
            case "a":
                System.out.println("Pattron A");
                for (int i = 1; i <= size; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("# ");
                    }
                    System.out.println();
                }
                break;

            case "b":
                System.out.println("Pattron B");
                for (int i = size; i >= 0; i--) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("# ");
                    }
                    System.out.println();
                }
                break;

            case "c":
                System.out.println("Pattron C");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("  ");
                    }
                    for (int j = 0; j < (size-i); j++) {
                        System.out.print("# ");
                    }
                    System.out.println();
                }
                break;

            case "d":
                System.out.println("Pattron D");
                for (int i = size-1; i >= 0; i--) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("  ");
                    }
                    for (int j = 0; j < (size-i); j++) {
                        System.out.print("# ");
                    }
                    System.out.println();
                }
                break;

            case "e":
                System.out.println("Pattron E");
                for (int i = 0; i < size; i++) {
                    if(i == 0 || i == size-1){
                        for (int j = 0; j < size; j++) {
                            System.out.print("# ");
                        }
                    }else {
                        for (int j = 0; j < size; j++) {
                            if (j == 0 || j == size-1){
                                System.out.print("# ");
                            }else {
                                System.out.print("  ");
                            }
                        }
                    }
                    System.out.println();
                }
                break;

            case "f":
                System.out.println("Pattron F");
                for (int i = 0; i < size; i++) {
                    if(i == 0 || i == size-1){
                        for (int j = 0; j < size; j++) {
                            System.out.print("# ");
                        }
                    }else {
                        for (int j = 0; j < size; j++) {
                            if (j == i){
                                System.out.print("# ");
                            }else {
                                System.out.print("  ");
                            }
                        }
                    }
                    System.out.println();
                }
                break;

            case "g":
                System.out.println("Pattron G");
                for (int i = 0; i < size; i++) {
                    if(i == 0 || i == size-1){
                        for (int j = 0; j < size; j++) {
                            System.out.print("# ");
                        }
                    }else {
                        for (int j = 0; j < size; j++) {
                            if (j == (size-i-1)){
                                System.out.print("# ");
                            }else {
                                System.out.print("  ");
                            }
                        }
                    }
                    System.out.println();
                }
                break;

            case "h":
                System.out.println("Pattron H");
                for (int i = 0; i < size; i++) {
                    if(i == 0 || i == size-1){
                        for (int j = 0; j < size; j++) {
                            System.out.print("# ");
                        }
                    }else {
                        for (int j = 0; j < size; j++) {
                            if ( j == i || j == (size-i-1)){
                                System.out.print("# ");
                            }else {
                                System.out.print("  ");
                            }
                        }
                    }
                    System.out.println();
                }
                break;

            case "i":
                System.out.println("Pattron I");
                for (int i = 0; i < size; i++) {
                    if(i == 0 || i == size-1){
                        for (int j = 0; j < size; j++) {
                            System.out.print("# ");
                        }
                    }else {
                        for (int j = 0; j < size; j++) {
                            if ( j == 0 || j == (size-1) || j == i || j == (size-i-1)){
                                System.out.print("# ");
                            }else {
                                System.out.print("  ");
                            }
                        }
                    }
                    System.out.println();
                }
                break;

            case "j":
                System.out.println("Pattron J");
                for (int i = 0; i < size/2 + (size%2==0 ? 0 : 1); i++) {
                    for (int j = 0; j < size; j++) {
                        if( j >= i && j <= size-i-1){
                            System.out.print("# ");
                        }else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
                break;

            case "k":
                System.out.println("Pattron K");
                for (int i = size/2-(size%2==0 ? 1 : 0); i >= 0 ; i--) {
                    for (int j = 0; j < size; j++) {
                        if( j >= i && j <= size-i-1){
                            System.out.print("# ");
                        }else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
                break;

            case "l":
                System.out.println("Pattron L");
                for (int i = 0; i < size; i++) {

                    System.out.println();
                }
                break;

            default:
                System.out.print("Patron no valida\r");
                break;
        }

    }
}
