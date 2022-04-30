package utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.cli.*;

@Getter
@NoArgsConstructor
public class CommandLineParser {
    private String strategy;
    private String input;
    private String output;
    private String action;

    private Options initiateCliOptions() {
        Options options = new Options();

        Option strategy = new Option("s",
                "strategy",
                true,
                StringConstants.STRATEGY_OPT_DESCRIPTION);
        strategy.setRequired(true);
        options.addOption(strategy);

        Option action = new Option("a", "action",
                true, StringConstants.ACTION_OPT_DESCRIPTION);
        action.setRequired(true);
        options.addOption(action);

        Option input = new Option("i", "input", true, "Input file or directory.");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("o", "output", true, "Output file or directory.");
        input.setRequired(true);
        options.addOption(output);

        return options;
    }

    public void parseCliArgs(String[] args) {
        DefaultParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        Options options = initiateCliOptions();

        try {
            CommandLine cmd = parser.parse(options, args);
            if (isStrategyValid(cmd.getOptionValue("strategy")))
                this.strategy = cmd.getOptionValue("strategy");
            else
                throw new ParseException(StringConstants.INCORRECT_STRATEGY_MESSAGE);
            if (isActionValid(cmd.getOptionValue("action")))
                this.action = cmd.getOptionValue("action");
            else
                throw new ParseException(StringConstants.INCORRECT_ACTION_MESSAGE);

            this.input = cmd.getOptionValue("input");
            this.output = cmd.getOptionValue("output");

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("photo-compresser", options);
            System.exit(1);
        }
    }

    private Boolean isStrategyValid(String strategy) {
        if (strategy.equalsIgnoreCase(Strategy.RECURSIVE.toString()) || strategy.equalsIgnoreCase(Strategy.FILE.toString()))
            return true;
        return false;
    }

    private Boolean isActionValid(String action) {
        if (action.equalsIgnoreCase(Action.COMPRESS.toString()) || action.equalsIgnoreCase(Action.DECOMPRESS.toString()))
            return true;
        return false;
    }
}
