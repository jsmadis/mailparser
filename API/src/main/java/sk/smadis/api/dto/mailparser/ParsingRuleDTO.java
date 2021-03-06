package sk.smadis.api.dto.mailparser;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import sk.smadis.api.dto.mailparser.enums.EmailComponent;
import sk.smadis.api.dto.mailparser.enums.FileLanguage;
import sk.smadis.api.dto.mailparser.enums.ParsingType;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="mailto:jakub.smadis@gmail.com">Jakub Smadiš</a>
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParsingRuleDTO {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private ParsingType parsingType;

    @NotNull
    private EmailComponent component;

    private FileLanguage fileLanguage = FileLanguage.ENG;

    private String rule;

    private MailboxDTO mailbox;

    private List<ParsedDataDTO> parsedData = new ArrayList<>();

    public ParsingRuleDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParsingType getParsingType() {
        return parsingType;
    }

    public void setParsingType(ParsingType parsingType) {
        this.parsingType = parsingType;
    }

    public EmailComponent getComponent() {
        return component;
    }

    public void setComponent(EmailComponent component) {
        this.component = component;
    }

    public FileLanguage getFileLanguage() {
        return fileLanguage;
    }

    public void setFileLanguage(FileLanguage fileLanguage) {
        this.fileLanguage = fileLanguage;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public MailboxDTO getMailbox() {
        return mailbox;
    }

    public void setMailbox(MailboxDTO mailbox) {
        this.mailbox = mailbox;
    }

    public List<ParsedDataDTO> getParsedData() {
        return parsedData;
    }

    public void setParsedData(List<ParsedDataDTO> parsedData) {
        this.parsedData = parsedData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParsingRuleDTO)) return false;
        ParsingRuleDTO that = (ParsingRuleDTO) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                getParsingType() == that.getParsingType() &&
                getComponent() == that.getComponent() &&
                getFileLanguage() == that.getFileLanguage() &&
                Objects.equals(getRule(), that.getRule()) &&
                Objects.equals(getParsedData(), that.getParsedData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getParsingType(), getComponent(), getFileLanguage(), getRule(), getParsedData());
    }
}
