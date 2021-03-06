package sk.smadis.api.dto.mailparser;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="mailto:jakub.smadis@gmail.com">Jakub Smadiš</a>
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailboxDTO {
    private Long id;

    private String name;

    private boolean resendRaw;

    private List<ParsingRuleDTO> parsingRules = new ArrayList<>();

    private List<StoredMessageDTO> storedMessages = new ArrayList<>();

    private UserDTO user;

    public MailboxDTO() {
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

    public boolean isResendRaw() {
        return resendRaw;
    }

    public void setResendRaw(boolean resendRaw) {
        this.resendRaw = resendRaw;
    }

    public List<ParsingRuleDTO> getParsingRules() {
        return parsingRules;
    }

    public void setParsingRules(List<ParsingRuleDTO> parsingRules) {
        this.parsingRules = parsingRules;
    }

    public List<StoredMessageDTO> getStoredMessages() {
        return storedMessages;
    }

    public void setStoredMessages(List<StoredMessageDTO> storedMessages) {
        this.storedMessages = storedMessages;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MailboxDTO)) return false;
        MailboxDTO that = (MailboxDTO) o;
        return isResendRaw() == that.isResendRaw() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getParsingRules(), that.getParsingRules()) &&
                Objects.equals(getStoredMessages(), that.getStoredMessages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), isResendRaw(), getParsingRules(), getStoredMessages());
    }
}
