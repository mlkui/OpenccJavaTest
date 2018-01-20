package com.mei.opencc;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.WString;

public interface Opencc extends Library
{
	Opencc INSTANCE = (Opencc) Native.loadLibrary("opencc", Opencc.class);

	public Pointer opencc_open(String configFileName);

	public Pointer opencc_open_w(WString configFileName);

	public int opencc_close(Pointer opencc);

	public int opencc_convert_utf8_to_buffer(Pointer opencc, String input, int length, String output);

	public String opencc_convert_utf8(Pointer opencc, String input, int length);

	public void opencc_convert_utf8_free(String input);

	public String opencc_error();
}
