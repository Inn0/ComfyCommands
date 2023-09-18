# ComfyCommands
## About
This project is a [Minecraft](https://www.minecraft.net/en-us) plugin for [Paper](https://papermc.io/) servers, made for Minecraft version 1.20.1. Build the project artifact, and place the .jar archive in the ```/plugins``` directory of your Paper server to get started.
This project is made with [Kotlin](https://kotlinlang.org/) and [Maven](https://maven.apache.org/). This project was made for casual multiplayer servers and aims to provide a few quality-of-life commands without altering gameplay.

## Commands
The following commands can be issued via the chat interface. You need permission to use these commands. For some commands players have permissions by default.

| Command       | Argument: Type                | Description                                                                                                                                         | Default permission | Example usage                             |
|---------------|-------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|--------------------|-------------------------------------------|
| /afk          |                               | Toggle AFK mode. When AFK a player is unable to move or jump, but is invulnerable. Their name also turns yellow in the player list and in the chat. | yes                | /afk                                      |
| /sleep        |                               | Sets the in-game time to morning and clears the weather.                                                                                            | yes                | /sleep                                    |
| /announce     | Message: String               | Send a message to all players using the server. The text shows up with the dollar sign prefix and in a blue color.                                  | no                 | /announce This is an announcement.        |
| /heal         |                               | Heals the user/issuer to full health and saturation.                                                                                                | no                 | /heal                                     |
| /savecoords   | Name: String                  | Saves the current coordinates of the user/issuer. Names have to be unique per player. Coordinates do not have to be unique.                         | yes                | /savecoords portal                        |
| /listcoords   | (OPTIONAL) Name: String       | Gets all saved coordinates. If an argument is present, all coordinates saved by that user are shown.                                                | yes                | /listcoords DatAsianPesuasio, /listcoords |
| /deletecoords | Name: String                  | Deletes saved coordinates by name. A player can only delete  their own coordinates.                                                                 | yes                | /deletecoords portal                      |
| /clearcoords  |                               | Clears all coordinates a user has saved. Users can only delete their own coordinates, this can not be undone.                                       | yes                | /clearcoords                              |
| /listperms    | (OPTIONAL) Name: String       | Gets all permissions a user has.                                                                                                                    | no                 | /listperms DatAsianPesuasio, /listperms   | 
| /giveperms    | Name: String, Command: String | Gives a user permission to use a command.                                                                                                           | no                 | /giveperms DatAsianPesuasio heal          |
| /revokeperms  | Name: String, Command: String | Revokes a user's permission to use a command.                                                                                                       | no                 | /revokeperms DatAsianPesuasio heal        |
| /clearperms   | Name: String                  | Revokes all of a user's permission to use any ComfyCommands command.                                                                                | no                 | /clearperms DatAsianPesuasio              |
| /ec           |                               | Opens a player's enderchest.                                                                                                                        | no                 | /ec                                       |

Having operator priviliges on a Minecraft server does not equal having permission to use all the ComfyCommands commands. Permission needs to be granted seperately, using the ```/giveperms <userName> <commandName>```.

## Listeners
1. Whenever a player dies, the coordinates where they died are shown in the chat. 
2. Every five seconds a players coordinates are updated on the player list (shown when a player presses ```tab``` ingame). The color the coordinates are listed in represent the dimension they are in (Overworld = green, end = purple, nether = red)

## Files
This project creates coordinates files in ```/comfycommands/coords/*.json``` and permission files in ```/comfycommands/coords/*.json```. Custom good morning messages can be provided in ```/comfycommands/strings/goodmorningmessages.json```

## Contact
Please reach out to [Daan](mailto:daan.brocatus@outlook.com) for suggestions, questions or for reporting bugs. 

Assigning admin priviliges to users is not yet implemented. 