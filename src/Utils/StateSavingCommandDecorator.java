package Utils;

import Commands.Command;

public class StateSavingCommandDecorator implements Command {
    private final Command command;

    public StateSavingCommandDecorator(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        // 保存状态用于撤销
        HtmlHistory.getInstance().saveState();

        command.execute();
    }
;}
