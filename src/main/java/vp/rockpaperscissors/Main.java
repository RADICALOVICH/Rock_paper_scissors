package vp.rockpaperscissors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("=== Камень, Ножницы, Бумага ===");
        System.out.println("Введите 'q' для выхода");

        while (true) {
            System.out.println("\nВыберите ход:");
            System.out.println("1 - камень");
            System.out.println("2 - бумага");
            System.out.println("3 - ножницы");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            Move playerMove = parseMove(input);
            if (playerMove == null) {
                System.out.println("Неверный ввод! Введите 1, 2 или 3");
                continue;
            }

            GameResult result = game.playRound(playerMove);
            Move computerMove = game.getLastComputerMove();

            System.out.println("Ваш ход: " + playerMove.getName());
            System.out.println("Ход компьютера: " + computerMove.getName());
            System.out.println(result.getMessage());

            System.out.println("\nСтатистика:");
            System.out.println("Побед: " + game.getPlayerWins());
            System.out.println("Поражений: " + game.getComputerWins());
            System.out.println("Ничьих: " + game.getDraws());
        }

        System.out.println("\nСпасибо за игру!");
        scanner.close();
    }

    private static Move parseMove(String input) {
        return switch (input) {
            case "1" -> Move.ROCK;
            case "2" -> Move.PAPER;
            case "3" -> Move.SCISSORS;
            default -> null;
        };
    }
}
