package net.feedthemadness.glib.command.test.privateroom;

import net.feedthemadness.glib.command.Command;
import net.feedthemadness.glib.command.dispatcher.CommandRegister;
import net.feedthemadness.glib.command.dispatcher.ICommandDispatcher;
import net.feedthemadness.glib.command.executor.ICommandExecutor;
import net.feedthemadness.glib.command.sub.SubArgument;
import net.feedthemadness.glib.command.sub.SubArgumentText;
import net.feedthemadness.glib.command.sub.SubCommand;
import net.feedthemadness.glib.command.sub.argument.SubArgumentTypeInt;

public class CommandManager {
	
	public void registers(ICommandDispatcher dispatcher) {
		ICommandExecutor executor = new CommandBotListener();
		
		CommandRegister.registerCommand(
				new Command()
				.setPrefix("%")
				.setLabelAndAliases("config", "c", "cfg")
				.addSubElement(
						new SubCommand("name", "rename")
						.addSubElement(
								new SubArgumentText()
								.addExecutor(executor, "config name")
								)
						)
				.addSubElement(
						new SubCommand("public")
						.addExecutor(executor, "config public")
						)
				.addSubElement(
						new SubCommand("private")
						.addExecutor(executor, "config private")
						)
				.addSubElement(
						new SubCommand("hide")
						.addExecutor(executor, "config hide")
						)
				.addSubElement(
						new SubCommand("whitelist", "wl")
						.addSubElement(
								new SubCommand("show", "=", "show-users", "=u", "show-roles", "=r")
								.addExecutor(executor, "config whitelist show")
								)
						.addSubElement(
								new SubCommand("add", "+", "add-user", "+u")
								.addSubElement(
										new SubArgument()
										.setType(new CommandTypeIdMention())
										.addExecutor(executor, "config whitelist add")
										)
								)
						.addSubElement(
								new SubCommand("remove", "-", "remove-user", "-u")
								.addSubElement(
										new SubArgument()
										.setType(new CommandTypeIdMention())
										.addExecutor(executor, "config whitelist remove")
										)
								)
						.addSubElement(
								new SubCommand("add-role", "+r", "add-r")
								.addSubElement(
										new SubArgument()
										.setType(new CommandTypeRole())
										.addExecutor(executor, "config whitelist add-role")
										)
								)
						.addSubElement(
								new SubCommand("remove-role", "-r", "remove-r")
								.addSubElement(
										new SubArgument()
										.setType(new CommandTypeRole())
										.addExecutor(executor, "config whitelist remove-role")
										)
								)
						)
				.addSubElement(
						new SubCommand("blacklist", "bl")
						.addSubElement(
								new SubCommand("show", "=", "show-users", "=u", "show-roles", "=r")
								.addExecutor(executor, "config blacklist show")
								)
						.addSubElement(
								new SubCommand("add", "+", "add-user", "+u")
								.addSubElement(
										new SubArgument()
										.setType(new CommandTypeIdMention())
										.addExecutor(executor, "config blacklist add")
										)
								)
						.addSubElement(
								new SubCommand("remove", "-", "remove-user", "-u")
								.addSubElement(
										new SubArgument()
										.setType(new CommandTypeIdMention())
										.addExecutor(executor, "config blacklist remove")
										)
								)
						.addSubElement(
								new SubCommand("add-role", "+r", "add-r")
								.addSubElement(
										new SubArgument()
										.setType(new CommandTypeRole())
										.addExecutor(executor, "config blacklist add-role")
										)
								)
						.addSubElement(
								new SubCommand("remove-role", "-r", "remove-r")
								.addSubElement(
										new SubArgument()
										.setType(new CommandTypeRole())
										.addExecutor(executor, "config blacklist remove-role")
										)
								)
						)
				.addSubElement(
						new SubCommand("moderators", "mods", "md")
						.addSubElement(
								new SubCommand("show", "=", "list")
								.addExecutor(executor, "config moderators show")
								)
						.addSubElement(
								new SubCommand("add", "+", "+u")
								.addSubElement(
										new SubArgument()
										.setType(new CommandTypeIdMention())
										.addExecutor(executor, "config moderators add")
										)
								)
						.addSubElement(
								new SubCommand("remove", "-", "-u")
								.addSubElement(
										new SubArgument()
										.setType(new CommandTypeIdMention())
										.addExecutor(executor, "config moderators remove")
										)
								)
						)
				.addSubElement(
						new SubCommand("userlimit", "user-limit", "limit")
						.addSubElement(
								new SubArgument()
								.setType(new SubArgumentTypeInt())
								.addExecutor(executor, "config userlimit")
								)
						),
				dispatcher);
	}
	
}
