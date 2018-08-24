# wsimport http://www.dneonline.com/calculator.asmx?WSDL
# The previous command is the one we need in order to generate the
# required class, but the command below adds to it some more options,
# to keep the generated source files, and to place them in the given
# directory. Run the command inside the sei directory.
mkdir src
wsimport -keep -s src http://www.dneonline.com/calculator.asmx?WSDL