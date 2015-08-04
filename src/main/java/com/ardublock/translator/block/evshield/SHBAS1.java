package com.ardublock.translator.block.evshield;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SHBAS1 extends TranslatorBlock {
	public SHBAS1 (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException, BlockException {
		
		translator.addHeaderFile("EVShield.h");

		
		return codePrefix + "SH_BAS1" + codeSuffix;
	}

}
