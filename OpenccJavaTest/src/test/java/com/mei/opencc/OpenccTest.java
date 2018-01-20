package com.mei.opencc;

import com.mei.opencc.Opencc;
import com.sun.jna.Pointer;

public class OpenccTest
{
	public static void main(String[] args)
	{
		try
		{
			String configFileName = "E:\\workspace-sts-3.3.0.RELEASE\\OpenccJavaTest\\lib\\t2s.json";
			Pointer opencc = Opencc.INSTANCE.opencc_open(configFileName);
			if (Pointer.nativeValue(opencc) == -1)
			{
				System.err.println(Opencc.INSTANCE.opencc_error());
				return;
			}

			String input = "中文簡繁轉換開源項目，支持詞彙級別的轉換、異體字轉換和地區習慣用詞轉換（中國大陸、臺灣、香港）";
			String output = Opencc.INSTANCE.opencc_convert_utf8(opencc, input, Integer.MAX_VALUE - 1);
			if (output == null)
			{
				System.err.println(Opencc.INSTANCE.opencc_error());
				return;
			}
			System.out.println(output);

			Opencc.INSTANCE.opencc_convert_utf8_free(output);
			System.out.println(Opencc.INSTANCE.opencc_close(opencc));
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}
	}
}
