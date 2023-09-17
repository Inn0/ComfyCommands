# ComfyCommands
## About
This project is a [Minecraft](https://www.minecraft.net/en-us) plugin for [Paper](https://papermc.io/) servers, made for Minecraft version 1.20.1. Build the project artifact, and place the .jar archive in the ```/plugins``` directory of your Paper server to get started.
This project is made with [Kotlin](https://kotlinlang.org/) and [Maven](https://maven.apache.org/). This project was made for casual multiplayer servers and aims to provide a few quality-of-life commands without altering gameplay.

## Commands
The following commands can be issued via the chat interface.

| Command       | Argument: Type            | Description                                                                                                                                         | Admin | Example usage                             |
|---------------|---------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|-------|-------------------------------------------|
| /afk          |                           | Toggle AFK mode. When AFK a player is unable to move or jump, but is invulnerable. Their name also turns yellow in the player list and in the chat. | no    | /afk                                      |
| /sleep        |                           | Sets the in-game time to morning and clears the weather.                                                                                            | no    | /sleep                                    |
| /coords       | Name: String              | Gets the current coordinates of a player.                                                                                                           | no    | /coords DatAsianPesuasio                  |
| /announce     | Message: String           | Send a message to all players using the server. The text shows up with the dollar sign prefix and in a blue color.                                  | yes   | /announce This is an announcement.        |
| /heal         |                           | Heals the user/issuer to full health and saturation.                                                                                                | yes   | /heal                                     |
| /savecoords   | Name: String              | Saves the current coordinates of the user/issuer. Names have to be unique per player. Coordinates do not have to be unique.                         | no    | /savecoords portal                        |
| /listcoords   | (OPTIONAL) Player: String | Gets all saved coordinates. If an argument is present, all coordinates saved by that user are shown.                                                | no    | /listcoords DatAsianPesuasio, /listcoords |
| /deletecoords | Name: String              | Deletes saved coordinates by name. A player can only delete  their own coordinates.                                                                 | no    | /deletecoords portal                      |
| /clearcoords  |                           | Clears all coordinates a user has saved. Users can only delete their own coordinates, this can not be undone.                                       | no    | /clearcoords                              |

For some commands you need admin priviliges within the plugin. These admin priviliges are not the same as being operator on the server.

## Contact
Please reach out to [Daan](mailto:daan.brocatus@outlook.com) for suggestions, questions or for reporting bugs. 

Assigning admin priviliges to users is not yet implemented. 