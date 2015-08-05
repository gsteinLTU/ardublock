package com.ardublock.translator.block.evshield;

import java.util.ArrayList;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Light extends TranslatorBlock {

	static ArrayList<String> usedports = new ArrayList<String>();
	
	public Light (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException, BlockException {

		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
		
		translator.addHeaderFile("EVs_NXTLight.h");
		
		if(!usedports.contains(tb.toCode())){
			usedports.add(tb.toCode());
		}

		translator.addDefinitionCommand("EVs_NXTLight light" + usedports.indexOf(tb.toCode()) + ";");
		
		translator.addSetupCommand("light" + usedports.indexOf(tb.toCode()) + ".init( &evshield, " + tb.toCode() + ");");
		translator.addSetupCommand("light" + usedports.indexOf(tb.toCode()) + ".setReflected();");
		
		return codePrefix + "light" + usedports.indexOf(tb.toCode()) + ".readRaw()" + codeSuffix;
		
	}

}
