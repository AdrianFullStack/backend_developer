package com.adrianfullstack.erp.util;

public class Formula {
	public Double hallarPromedio(Double[] cadenaDeNumeros){
        if(cadenaDeNumeros == null){
            System.out.println("la cadena de numeros es nula, no puedo hallar elpromedio");
            return null;
        }

        Integer qNumeros = cadenaDeNumeros.length;
        Double sumatoria = 0.0;
        
        sumatoria = this.hallarSumatoria(cadenaDeNumeros);
        
        Double promedio = sumatoria / qNumeros;
        return promedio;
    }
    
    public Double[] hallarCuadradoDelValorAbsolutoDeLasDistanciasAlPromedio(Double[] cadenaDeNumeros, Double promedio){
        if(cadenaDeNumeros == null){
            System.out.println("la cadena de numeros es nula, no puedo hallar la distancia al promedio");
            return null;
        }
        Double[] distanciasAlPromedio = new Double[cadenaDeNumeros.length];
        for (int i = 0; i < cadenaDeNumeros.length; i++) {
            Double numeroActual = cadenaDeNumeros[i];
            Double distancia = numeroActual - promedio;

            Double distanciaAbsoluto = Math.abs(distancia);
            Double cuadradoDelAbsoluto = Math.pow(distanciaAbsoluto, 2);
            distanciasAlPromedio[i] = cuadradoDelAbsoluto;
        }
        return distanciasAlPromedio;
    }
    
    public Double hallarSumatoria(Double[] distanciasAlpromedio){
        if(distanciasAlpromedio == null){
            System.out.println("Error, las distanciasAlpromedio es nula, no puedo hallar la sumatoria");
            return null;
        }
        Double sumatoria = 0.0;
        for (int i = 0; i < distanciasAlpromedio.length; i++) {
            Double distancia = distanciasAlpromedio[i];
            sumatoria += distancia;
        }
        return sumatoria;
    }
    
    public Double hallarDesviacionEstandar(Double[] cadenaDeNumeros){
        Double desviacionEstandar = 0.0;
        if(cadenaDeNumeros == null){
            System.out.println("la cadena de numeros es nula, no puedo hallar la desviacion estandar");
            return null;
        }
        
        Integer qNumeros = cadenaDeNumeros.length;
        
        Double promedio = this.hallarPromedio(cadenaDeNumeros);

        Double[] cuadradoDelAbsolutoDeLasdistanciasAlPromedio = this.hallarCuadradoDelValorAbsolutoDeLasDistanciasAlPromedio(cadenaDeNumeros, promedio);
        
        Double sumatoriaDelCuadradoDelAbsolutoDeLaDist = this.hallarSumatoria(cuadradoDelAbsolutoDeLasdistanciasAlPromedio);

        Double divisionSumatoriaCuadradoYQNumeros = sumatoriaDelCuadradoDelAbsolutoDeLaDist / qNumeros;

        desviacionEstandar = Math.sqrt(divisionSumatoriaCuadradoYQNumeros);
        return desviacionEstandar;
    }
}
