import Commands.Command;

public class CommandCaller {
    private static String[] splitInput(String input){
        return input.split(" ");
    }

    public static Command createCommand(String input) {
        String[] splitInput = splitInput(input);
        String commandType = splitInput[0];
        int newArrayLength = splitInput.length - 1;
        String[] commandArgs = new String[newArrayLength];
        if(splitInput.length > 1){
            System.arraycopy(splitInput, 1, commandArgs, 0, newArrayLength);
        }
        Command command = CommandFactory.createCommand(commandType, commandArgs);
        return command;
    }

    public void executeCommand(String input) {
        switch (input) {
            case "uninitialized":
                System.out.println("Uninitialized! Use init or read first");
                break;
            case "unknown":
                System.out.println("Unknown command!");
                break;
            default:
                Command command = createCommand(input);
                command.execute();
                break;
        }
    }
}
