package com.neuedu.examonline.base.classsys;

import java.sql.*;
import java.util.*;
import com.neuedu.examonline.db.*;
public class release {

	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static ConnectionFactory cf = new ConnectionFactory();
	public static void releasec(Connection ct, PreparedStatement ps, ResultSet rs)
    {

        if (ct != null)
        {
            if (ps != null)
            {
                if (rs != null)
                {
                    try
                    {
                        rs.close();
                    } catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
                try
                {
                    ps.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            try
            {
                ct.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }
}

