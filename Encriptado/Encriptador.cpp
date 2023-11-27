// Native methods implementation of
// C:/Users/karoe/Documents/NetBeansProjects/EncriptadorDeArchivos/src/Encriptador.java

#include "Encriptador.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
using namespace std;

JNIEXPORT jchar JNICALL Java_Todo_Encriptador_encriptarROT47
(JNIEnv * env, jobject obj, jchar v)
{
    jchar n;
    __asm{
        MOVZX AX,v //mover extension 0
        CMP AX,32 //es espacio?
        JE fin//no se les hace nada a espacio
        
        CMP AX,79
        JBE lower //es menor o igual
        
        SUB AX,47 //v=mayor-47
        JMP fin
        
        lower:
        ADD AX,47//v=menor+47
        
        fin:
        MOV n,AX
        }    
    return n;
}

JNIEXPORT jint JNICALL Java_Todo_Encriptador_compararCadenas
(JNIEnv *env, jobject obj, jstring jstr1, jstring jstr2)
{
    const char* cstr1 = env->GetStringUTFChars(jstr1,nullptr);
    const char* cstr2 = env->GetStringUTFChars(jstr2,nullptr);
    int res=0;
    __asm{
        MOV ESI,cstr1
        MOV EDI,cstr2
        
        L1:
        MOV AL,[ESI]
        MOV BL,[EDI]//mover a registro char
        
        INC ESI//dirigir a siguiente
        INC EDI
                
        CMP AL,BL //0 -> igual
        JNE NO
        TEST AL,AL //llego al final?
        JZ YES
        TEST BL,BL
        JZ YES
        JMP L1
        
        YES:
        MOV res,1
        JMP fin
        
        NO:
        MOV res,0
        
        fin:
    } 
    env->ReleaseStringUTFChars(jstr1, cstr1);
    env->ReleaseStringUTFChars(jstr2, cstr2);
    return res;
}

JNIEXPORT jchar JNICALL Java_Todo_Encriptador_generarChar
(JNIEnv* env, jobject obj,jint num)
{
    srand(time(NULL));
    jchar n = (rand() % 85)+33+num;
    return n;
}

