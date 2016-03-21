package by.userTable.commands;

/**
 * Created by Narek on 12/11/2015.
 */
public enum CommandEnum {
    IMPORTCVS{
        {
            this.command=new ImportCSVCom();
        }
    },
    MAIN{
        {
            this.command=new MainCommand();
        }
    },
    USERS{
        {
            this.command=new UsersCommand();
        }
    },
    UPLOAD{
        {
            this.command=new UploadCommand();
        }
    },
    GOTO{
        {
            this.command=new UsersCommand();
        }
    },
    NEXT{
        {
            this.command=new UsersCommand();
        }
    },
    PREVIOUS{
        {
            this.command=new UsersCommand();
        }
    }
    ;
    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
