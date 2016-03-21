package by.userTable.SQLEnum;

/**
 * Created by Narek on 12/11/2015.
 */
public enum SelectSQL {

    NAME_UP{
        {
            this.sql="ORDER BY name ASC";
        }
    },
    NAME_DOWN{
        {
            this.sql="ORDER BY name DESC";
        }
    },
    SURNAME_UP{
        {
            this.sql="ORDER BY surname ASC";
        }
    },
    SURNAME_DOWN{
        {
            this.sql="ORDER BY surname DESC";
        }
    },
    LOGIN_UP{
        {
            this.sql="ORDER BY login ASC";
        }
    },
    LOGIN_DOWN{
        {
            this.sql="ORDER BY name DESC";
        }
    },
    EMAIL_UP{
        {
            this.sql="ORDER BY email ASC";
        }
    },
    EMAIL_DOWN{
        {
            this.sql="ORDER BY email DESC";
        }
    },
    NUMBER_UP{
        {
            this.sql="ORDER BY number ASC";
        }
    },
    NUMBER_DOWN{
        {
            this.sql="ORDER BY number DESC";
        }
    };

    String sql;
    public String getSQL(){
        return sql;
    }
}
