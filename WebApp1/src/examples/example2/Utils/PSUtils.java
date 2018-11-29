package examples.example2.Utils;
import java.sql.PreparedStatement;

public class PSUtils {
	public static void setAll(PreparedStatement pstmt, Object... params){
		try {
			for(int i = 0; i < params.length; i++) {
				switch(params[i].getClass().getTypeName()) {
					case "int":
						pstmt.setInt(i,(int)params[i]);
						break;
					case "float":
						pstmt.setFloat(i,(float)params[i]);
						break;
					case "double":
						pstmt.setDouble(i,(double)params[i]);
						break;
					case "String":
						pstmt.setString(i,(String)params[i]);
						break;
					default:
						throw new IllegalArgumentException();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
