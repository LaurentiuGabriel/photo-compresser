# photo-compresser :camera: :rocket:

![Maven Build](https://github.com/LaurentiuGabriel/photo-compresser/actions/workflows/maven.yml/badge.svg)
![Dockerisation](https://github.com/LaurentiuGabriel/photo-compresser/actions/workflows/docker-image.yml/badge.svg)
![Dependency Review](https://github.com/LaurentiuGabriel/photo-compresser/actions/workflows/dependency-review.yml/badge.svg)
![Dependency Review](https://github.com/LaurentiuGabriel/photo-compresser/actions/workflows/maven-test.yml/badge.svg)

A tool for compressing photos captured in raw format. 
Basically, what this program does is to dehydrate the files to allow users to store them in cloud or on local drive.
The dehydrated files can always be hydrated to their original state, without losing quality. This way you can save space on your cloud or local drive. 

## Usage 
This tool is a CLI application that accepts the following arguments:
- action: this can be **compress** or **decompress**. Compress will reduce the file size, whereas decompress will recreate the file in its original state.
- strategy: this argument can be recursive, or file. Recursive is used when you want to apply the compression to a directory, applying it to all the files inside it. File compression is when individual files are used.
- input: this is the path to the input file, or directory, in the case that recursive strategy is used
- output: this is the path to the output file, or directory, if the recursive strategy is used.

## Notes
This tool works only with raw format pictures, such as NEF files for Nikon, or CR2/CR3 for Canon. If you supply a different file, the program will run, but the results will be unpredictable. Applying it on already-compressed files, such as jpeg, won't reduce the file size even more.