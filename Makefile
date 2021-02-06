idir := src
odir := bin

rwildcard = $(foreach d,$(wildcard $(1:=/*)),$(call rwildcard,$d,$2) $(filter $(subst *,%,$2),$d))
src_files = $(call rwildcard,$(idir),*.java)
src_names = $(src_files:$(idir)/%.java=%)
artifacts = $(src_names:%=$(odir)/%.class)

javac_args = -cp $(idir) -d $(odir)
java_args  = -cp $(odir)

$(odir)/%.class: $(idir)/%.java
	@echo ----- MAK $< -----
	@-javac $(javac_args) $<

entry ?= Main

run: $(artifacts)
	@echo ----- RUN $(entry) -----
	@java $(java_args) $(entry)
	@echo ----- END $(entry) -----
