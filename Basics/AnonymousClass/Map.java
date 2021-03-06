package AnonymousClass;

public class Map<I,O>{
	O[] map(Function<I,O> func,I[] inp){
		Object[] out = new Object[inp.length];
		for(int i=0;i<inp.length;i++){
			out[i]  = func.func(inp[i]);
		}
		return (O[])out;
	}
	
//	O[] map(Function<I,O> func,I[] inp){
//		for(int i=0;i<inp.length;i++){
//			inp[i]  = (I)func.func(inp[i]);
//		}
//		return ((O[])inp);
//	}



}

interface Function<I,O>{
	O func(I input);
}
