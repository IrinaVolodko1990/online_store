package by.volodko.epam.online_store.controller.command;

import by.volodko.epam.online_store.controller.command.impl.DefaultCommand;
import by.volodko.epam.online_store.controller.command.impl.StartPageCommand;

import java.util.EnumMap;
import java.util.Locale;

import static by.volodko.epam.online_store.controller.command.CommandType.*;

public class CommandProvider {
    private static CommandProvider instance;
    private final EnumMap<CommandType, Command> commands = new EnumMap(CommandType.class);

     private CommandProvider(){
        commands.put(START_PAGE_COMMAND, new StartPageCommand());
        commands.put(DEFAULT, new DefaultCommand());
    }
    public static CommandProvider getInstance(){
         if(instance==null){instance = new CommandProvider();
         }
         return instance;
    }
    public Command getCommand (String commandName){
         if (commandName == null){
             return commands.get(DEFAULT);
         }
         else {
             CommandType commandType;
             try {
                 commandType = valueOf(commandName.toUpperCase());
             } catch(IllegalArgumentException e){
                 commandType = DEFAULT;
             }
             return commands.get(commandType);
         }
    }
}
