package hwxy.examol.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 转换请求参数类型
 */
public class HttpServletRequestUtil
{
    /**
     * 返回int
     * @param request
     * @param key
     * @return
     */
    public static int getInt(HttpServletRequest request, String key)
    {
        try {
            return Integer.decode(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }

    /**
     * 返回long
     * @param request
     * @param key
     * @return
     */
    public static long getLong(HttpServletRequest request, String key)
    {
        try {
            return Long.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1L;
        }
    }

    /**
     * 返回double
     * @param request
     * @param key
     * @return
     */
    public static double getDouble(HttpServletRequest request, String key)
    {
        try {
            return Double.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1D;
        }
    }

    /**
     * 返回boolean
     * @param request
     * @param key
     * @return
     */
    public static boolean getBoolean(HttpServletRequest request, String key)
    {
        try {
            return Boolean.valueOf(request.getParameter(key));
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 返回String
     * @param request
     * @param key
     * @return
     */
    public static String getString(HttpServletRequest request, String key)
    {
        try {
            String result = request.getParameter(key);
            if (request != null)
            {
                result = result.trim();
            }
            if ("".equals(result))
            {
                result = null;
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }

}
