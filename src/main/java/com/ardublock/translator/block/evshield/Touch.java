package com.ardublock.translator.block.evshield;

import java.util.ArrayList;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Touch extends TranslatorBlock {
	
	static ArrayList<String> usedports = new ArrayList<String>();
	
	public Touch (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException, BlockException {

		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
		
		translator.addHeaderFile("EVs_EV3Touch.h");
		
		if(!usedports.contains(tb.toCode())){
			usedports.add(tb.toCode());
		}

		translator.addDefinitionCommand("EVs_EV3Touch touch" + usedports.indexOf(tb.toCode()) + ";");
		
		translator.addSetupCommand("touch" + usedports.indexOf(tb.toCode()) + ".init( &evshield, " + tb.toCode() + ");");
		
		return codePrefix + "touch" + usedports.indexOf(tb.toCode()) + ".isPressed()" + codeSuffix;
		
	}
}
