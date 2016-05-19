cd src
cd bin
for /r %%i in (../tests/*) do java game.Main < ../tests/%%~nxi > ../results/%%~nxi
cd ..
cd ..