INCLUDE C:\Irvine\Irvine32.inc
INCLUDELIB C:\Irvine\Irvine32.lib
INCLUDELIB \masm32\lib\kernel32.lib
INCLUDELIB \masm32\lib\user32.lib
.386
.stack 4096

.data
fileHandle DWORD ?
buffer BYTE 256 DUP (?)
bytesLeidos DWORD ?
bytesEscritos DWORD ?
captura BYTE "Archivo",0
.code
Java_Encriptador_encriptar PROC JNIEnv:DWORD, jobject:DWORD, fileD:BYTE

	Invoke MessageBox,0,ADDR fileD,ADDR captura,MB_OK ;para ver como toma el parametro 

	Invoke CreateFile, ADDR fileD, GENERIC_READ or GENERIC_WRITE, 0, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL ;abrir archivo
	mov fileHandle, eax; referencia de archivo

	cmp fileHandle, INVALID_HANDLE_VALUE ;se encontro?
	je error

	Invoke ReadFile, fileHandle,ADDR buffer, SIZEOF buffer,ADDR bytesLeidos,0 ;leer archivo

	cmp eax,0 ;se leyo?
	je errorL

	mov ecx,bytesLeidos 
	mov esi,0
	repite:
	mov buffer[esi],1 ;remplazar con 1 characteres(temporal)
	INC esi
	loop repite

	Invoke WriteFile, fileHandle,ADDR buffer, SIZEOF buffer,ADDR bytesEscritos,0 ;escribir al archivo, lo que esta en buffer 

	cmp eax,0 ;se escribio?
	je errorE

	jmp fin

	error:
	mov eax,3
	RET
	errorL:
	mov eax,2
	RET
	errorE:
	mov eax,1   ;indicar error
	RET
	fin:
	Invoke CloseHandle, fileHandle ;se abrio archivo, se debe cerrar
	mov eax,0 ;no hubo error
	RET
Java_Encriptador_encriptar ENDP

Java_Encriptador_desencriptar PROC JNIEnv:DWORD, jobject:DWORD, fileD:BYTE

	;seria lo mismo con algunas diferencias

	RET
Java_Encriptador_desencriptar  ENDP

END

