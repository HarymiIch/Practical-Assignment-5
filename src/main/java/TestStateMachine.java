package org.example;

public class TestStateMachine {

    public String process(String input) {
        if (input == null) {
            return "S";
        }

        char currentState = 'S';

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (currentState == 'F') {
                currentState = 'F';
                continue;
            }

            switch (currentState) {
                case 'S':
                    if (c == 'T') {
                        currentState = '1';
                    }
                    break;

                case '1':
                    if (c == 'E') {
                        currentState = '2';
                    } else if (c == 'T') {
                        currentState = '1';
                    } else {
                        currentState = 'S';
                    }
                    break;

                case '2':
                    if (c == 'S') {
                        currentState = '3';
                    } else if (c == 'T') {
                        currentState = '1';
                    } else {
                        currentState = 'S';
                    }
                    break;

                case '3':
                    if (c == 'T') {
                        currentState = 'F';
                    } else if (c == 'E') {
                        currentState = '2';
                    } else {
                        currentState = 'S';
                    }
                    break;
            }
        }

        return String.valueOf(currentState);
    }
}