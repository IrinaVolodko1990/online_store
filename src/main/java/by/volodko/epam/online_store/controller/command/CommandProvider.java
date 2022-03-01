package by.volodko.epam.online_store.controller.command;

import by.volodko.epam.online_store.controller.command.impl.StartPageCommand;

import java.util.EnumMap;

import static by.volodko.epam.online_store.controller.command.CommandType.*;

public class CommandProvider {
    private static CommandProvider instance;
    private final EnumMap<CommandType, Command> commands = new EnumMap(CommandType.class);

    // private CommandProvider(){
      //  commands.put(START_PAGE_COMMAND, new StartPageCommand())
   // }
}
